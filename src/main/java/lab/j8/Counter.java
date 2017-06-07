package lab.j8;

public class Counter {

    private long sum=0;

    public void add(int value){
        this.sum += value;
    }

    public long getSum() {
        return sum;
    }
}
