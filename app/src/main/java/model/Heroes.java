package model;

public class Heroes {
    private String image;
    private String _id;
    private String name;
    private String desc;

    public Heroes(String _id) {
        this._id = _id;
    }

    public Heroes(String name, String desc, String image) {
        this.name = name;
        this.desc = desc;
        this.image=image;
    }


    public String getImage(){
        return image;
    }
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
