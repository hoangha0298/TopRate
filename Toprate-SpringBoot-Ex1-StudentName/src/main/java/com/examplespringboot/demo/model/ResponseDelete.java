package com.examplespringboot.demo.model;

/*phản hồi khi xóa khách hàng*/
public class ResponseDelete {

    private boolean sucess;

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }
}
