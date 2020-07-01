package com.training.ykb.spring;


public class KitchenResponse {

    private Boolean success;
    private String  note;
    private int     finishTimeInMinutes;


    public Boolean getSuccess() {
        return this.success;
    }

    public KitchenResponse setSuccess(final Boolean successParam) {
        this.success = successParam;
        return this;
    }


    public String getNote() {
        return this.note;
    }


    public KitchenResponse setNote(final String noteParam) {
        this.note = noteParam;
        return this;
    }


    public int getFinishTimeInMinutes() {
        return this.finishTimeInMinutes;
    }


    public KitchenResponse setFinishTimeInMinutes(final int finishTimeInMinutesParam) {
        this.finishTimeInMinutes = finishTimeInMinutesParam;
        return this;
    }


    public static KitchenResponse fail(final String stringParam) {
        return new KitchenResponse().setSuccess(false)
                                    .setNote(stringParam);
    }

    public static KitchenResponse success(final String noteStringParam,
                                          final int minuteToFinish) {
        return new KitchenResponse().setSuccess(true)
                                    .setNote(noteStringParam)
                                    .setFinishTimeInMinutes(minuteToFinish);
    }

}
