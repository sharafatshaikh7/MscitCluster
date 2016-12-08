package mscitcluster.com.mscitcluster;

/**
 * Created by yasmeenshaikh on 4/7/2016.
 */
public class student_data {

    private String name;
    private String mob_number;
    private String emai_id;
    private String pass;
    private String confirm_pass;
    private String part;
    private String college;

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
/*
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
*/

//    private String image;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConfirm_pass() {
        return confirm_pass;
    }

    public void setConfirm_pass(String confirm_pass) {
        this.confirm_pass = confirm_pass;
    }

    public String getEmai_id() {
        return emai_id;
    }

    public void setEmai_id(String emai_id) {
        this.emai_id = emai_id;
    }

    public String getMob_number() {
        return mob_number;
    }

    public void setMob_number(String mob_number) {
        this.mob_number = mob_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
