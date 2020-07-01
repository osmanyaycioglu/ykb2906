package com.training.ykb.spring;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    public String fullfillOrder4(@RequestBody final Order orderParam) {
        String payLoc = this.ior.pay(orderParam);
        if (OrderRest.logger.isInfoEnabled()) {
            OrderRest.logger.info("[OrderRest][fullfillOrder4]-> Response : " + payLoc);
        }
        if ((payLoc != null) && payLoc.startsWith("OK")) {
            return "Siparişiniz alındı.En kısa zamanda gönderilecekltir";
        }
        return "Ödemede problem oluştu";
    }

}
