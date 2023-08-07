package bai13expert.entities;

import java.io.Serializable;

public class Certificate implements Serializable {
    private String certificateID;
    private String certificateName;
    private int certificateRank;
    private String certificateDate;

    public Certificate(String certificateID, String certificateName, int certificateRank, String certificateDate) {
        this.certificateID = certificateID;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificateDate = certificateDate;
    }
}
