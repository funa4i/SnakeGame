package Enums;

public enum Status {
    Alive(1),
    Die(0);

    private int val;

    Status(int val){
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
