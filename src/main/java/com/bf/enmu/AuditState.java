package com.bf.enmu;

/**
 * @description:
 * @author: bofei
 * @date: 2019-09-03 16:51
 **/
public enum AuditState {
    UNAUDIT(1),

    AUDITING(2),

    AUDIT_SUCCESS(3),

    AUDIT_FAIL(4);private final int statenum;

    AuditState(int statenum){

        this.statenum = statenum;

    }

    public int getStatenum() {

        return statenum;

    }

    public static void main(String[] args) {
        System.out.println(AuditState.UNAUDIT.getStatenum());
        System.out.println(AuditState.UNAUDIT.toString());
    }

}
