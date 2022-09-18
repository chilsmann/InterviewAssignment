

public class Record implements Comparable<Record>{
    private String firstName;
    private String lastName;
    private String address;
    private int age;

    public Record(String firstName,String lastName,String address,int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName){this.firstName = firstName;}

    public void setLastName(String lastName){this.lastName = lastName;}

    public void setAddress(String address){this.address = address;}

    public void setAge(int age){this.age = age;}

    @Override
    public String toString(){
       return (this.firstName+" "+ this.lastName+" "+ this.address+", "+this.age);
    }

    @Override
    public int compareTo(Record o) {
        int i = this.address.compareToIgnoreCase(o.address);

        if(i == 0){
            i = this.lastName.compareToIgnoreCase(o.lastName);
        }
        if(i == 0){
            i = this.firstName.compareToIgnoreCase(o.firstName);
        }
        return i;
    }
}
