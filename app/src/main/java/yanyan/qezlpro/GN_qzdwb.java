package yanyan.qezlpro;

/**
 * Created by Administrator on 2017/8/3 0003.
 */

public class GN_qzdwb {
    String ywb="";
    String qmwb="";
    String hmwb="";

    public GN_qzdwb()
    {

    }

   public String[] kshq(String ywb,String qmwb,String hmwb)
    {



        int start = 0;
        int gsa = 0;
        int gsb=0;
        while (ywb.indexOf(qmwb,start) >= 0 && start < ywb.length()) {
            gsa++;


            start = ywb.indexOf(qmwb,start) + qmwb.length();
            if(ywb.indexOf(hmwb,start)>=0)
            {
                gsb++;
            }
        }
        if(gsb<gsa)
        {gsa=gsb;}
        int wz=0;

   String []aa = new String[gsa];
        for (int i=0;i<gsa;i++)
        {
            String fhwb="";
            fhwb= ywb.substring(ywb.indexOf(qmwb,wz)+qmwb.length(),ywb.indexOf(hmwb,ywb.indexOf(qmwb,wz)+qmwb.length()));
            wz=ywb.indexOf(hmwb,ywb.indexOf(qmwb,wz)+qmwb.length())+hmwb.length();
            aa[i]=fhwb;
        }
        return aa;
    }

public String kshq2(String ywb,String qmwb,String hmwb)
{
    String fhzf="";
   fhzf= ywb.substring(ywb.indexOf(qmwb)+qmwb.length(),ywb.indexOf(hmwb,ywb.indexOf(qmwb)+qmwb.length()));
    return fhzf;
}
}


