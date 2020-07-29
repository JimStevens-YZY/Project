package entity;
public class FoodEntity {
    private String id;
    private String name;
    private String ways;
    private String time;
    private String address;
    private String phonenumber;
    private String order;
    private String consumption;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getWays() {
        return ways;
    }
    public void setWays(String ways) {
        this.ways =ways;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time =time;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
        this.order = order;
    }

    public String getConsumption() { return consumption; }
    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }
    @Override
    public String toString() {
        return "FoodEntity [id=" + id + ", name=" + name + ", ways=" + ways + ", time=" + time
                + ", address=" + address + ",phonenumber=" + phonenumber + ",order=" + order + ",consumption=" + consumption + "]";
    }
}
