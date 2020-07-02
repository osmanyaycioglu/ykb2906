package com.training.ykb.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderRest {

    private static final Logger logger = LoggerFactory.getLogger(OrderRest.class);

    @Autowired
    @LoadBalanced
    private RestTemplate        rt;

    @Autowired
    private EurekaClient        ec;

    @Autowired
    @Qualifier("direct")
    private RestTemplate        rtDirect;

    @Autowired
    private IOrderRest          ior;

    @Autowired
    private IKitchenClient      kc;

    @Autowired
    private RabbitTemplate      rabbitt;

    @Value("${abc.xyz}")
    private String              abcXyz;

    @GetMapping("/refreshtest")
    public String strTest() {
        return this.abcXyz;
    }

    @PostMapping("/fullfill")
    public String fullfillOrder(@RequestBody final Order orderParam) {
        String forObjectLoc = this.rt.postForObject("http://CUSTOMER/order/pay",
                                                    orderParam,
                                                    String.class);
        System.out.println(forObjectLoc);
        if ((forObjectLoc != null) && forObjectLoc.startsWith("OK")) {
            return "Siparişiniz alındı.En kısa zamanda gönderilecekltir";
        }
        return "Ödemede problem oluştu";
    }

    @PostMapping("/fullfill2")
    public String fullfillOrder2(@RequestBody final Order orderParam) {
        InstanceInfo ii = this.ec.getNextServerFromEureka("CUSTOMER",
                                                          false);
        String forObjectLoc = this.rtDirect.postForObject("http://"
                                                          + ii.getIPAddr()
                                                          + ":"
                                                          + ii.getPort()
                                                          + "/order/pay",
                                                          orderParam,
                                                          String.class);
        System.out.println(forObjectLoc);
        if ((forObjectLoc != null) && forObjectLoc.startsWith("OK")) {
            return "Siparişiniz alındı.En kısa zamanda gönderilecekltir";
        }
        return "Ödemede problem oluştu";
    }

    @PostMapping("/fullfill3")
    public String fullfillOrder3(@RequestBody final Order orderParam) {
        Application applicationLoc = this.ec.getApplication("CUSTOMER");
        List<InstanceInfo> instancesLoc = applicationLoc.getInstances();
        for (InstanceInfo instanceInfoLoc : instancesLoc) {
            System.out.println(instanceInfoLoc);
        }
        String forObjectLoc = this.rtDirect.postForObject("http://"
                                                          + instancesLoc.get(0)
                                                                        .getIPAddr()
                                                          + ":"
                                                          + instancesLoc.get(0)
                                                                        .getPort()
                                                          + "/order/pay",
                                                          orderParam,
                                                          String.class);
        System.out.println(forObjectLoc);
        if ((forObjectLoc != null) && forObjectLoc.startsWith("OK")) {
            return "Siparişiniz alındı.En kısa zamanda gönderilecekltir";
        }
        return "Ödemede problem oluştu";
    }

    @PostMapping("/fullfill4")
    public ResponseEntity<String> fullfillOrder4(@RequestBody final Order orderParam) {
        String payLoc = this.ior.pay(orderParam);
        if (OrderRest.logger.isInfoEnabled()) {
            OrderRest.logger.info("[OrderRest][fullfillOrder4]-> Response : " + payLoc);
        }
        if ((payLoc == null) || !payLoc.startsWith("OK")) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                                 .body("Ödeme başarısız.");
        }
        try {
            KitchenResponse startCookLoc = this.kc.startCook(orderParam);
            if (startCookLoc.getSuccess()) {
                this.rabbitt.convertAndSend("not_direct_exc",
                                            "notification_key",
                                            orderParam);
                return ResponseEntity.status(HttpStatus.OK)
                                     .body("Siparişiniz alındı."
                                           + startCookLoc.getNote()
                                           + "."
                                           + startCookLoc.getFinishTimeInMinutes()
                                           + " dakika içinde siparişiniz kapınızda.");
            } else {
                return ResponseEntity.status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
                                     .body("Şu anda mutfağımız dolu");
            }
        } catch (MyValidationException eLoc) {
            OrderRest.logger.error("[OrderRest][fullfillOrder4]-> *Error*------************ : "
                                   + eLoc.getError()
                                   + " path : "
                                   + eLoc.getPath()
                                   + " message : "
                                   + eLoc.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Girdiler yanlış");
        } catch (Exception eLoc) {
            OrderRest.logger.error("[OrderRest][fullfillOrder4]-> *Error* : " + eLoc.getMessage(),
                                   eLoc);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Problem");

        }

    }

}
