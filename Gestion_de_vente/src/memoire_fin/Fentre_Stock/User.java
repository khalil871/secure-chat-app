
package memoire_fin.Fentre_Stock;


import java.sql.PreparedStatement;

public class User {
    
  static PreparedStatement ps;
String id, Name, Quantite,Os,Nfc,Notch, Annonced,Color, Prix, Size,Multiple, Rearcamera, Selfiecamera,technologie, Ram, cpu, battery;
 
public User(String Id, String name, String annonced, String quantite,String prix, String color,
           String rearcamera,String selfiecamera, String ram, String cPu, String size, 
            String baTtery) {
        id = Id;
        Name = name;
        Annonced = annonced;
        Quantite = quantite;
        Color = color;
        Prix = prix;
        Rearcamera = rearcamera;
        Selfiecamera = selfiecamera;
        Ram = ram;
        cpu = cPu;
        Size = size;
        battery = baTtery;
        
        
    }
  
    public User (String Name, String Quantite, String Annonced, String Color,
            String Prix, String ram
           ) {
        
        this.Name = Name;
        this.Quantite = Quantite;
        this.Annonced = Annonced;
        this.Color = Color;
        this.Prix = Prix;
        this.Ram = ram;
      
    }
   
    
    
    /*
      public User( String Name, String Quantite){
       
        this.Name = Name;
        this.Quantite = Quantite;
        
      }*/
      
     
      
    public User(String Id, String name,String ram,String quantite,String prix,String technolog,String size,String multiple,
                String os,String nfc,String notch,String rearcamera,String selfiecamera) {
        id = Id;
        Name = name;
        Ram=ram;
        Quantite =quantite;
        Prix = prix;
        technologie = technolog;
        Size=size;
        Multiple=multiple;
        Os=os;
         Nfc=nfc;
        Notch=notch;
        Rearcamera=rearcamera;
        Selfiecamera=selfiecamera;
        
        
        
    }
      
   

    public String getAnnonced() {
        return Annonced;
    }

    public String getBattery() {
        return battery;
    }

    public String getTechnologie() {
        return technologie;
    }

    public String getMultiple() {
        return Multiple;
    }

    public String getOs() {
        return Os;
    }

    public String getNfc() {
        return Nfc;
    }

    public String getNotch() {
        return Notch;
    }
   
    

   

    public String getCpu() {
        return cpu;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return Name;
    }
     public String getColor() {
        return Color;
    }

    public String getPrix() {
        return Prix;
    }

    public String getQuantite() {
        return Quantite;
    }

    public String getRam() {
        return Ram;
    }

    public String getRearcamera() {
        return Rearcamera;
    }

    public String getSelfiecamera() {
        return Selfiecamera;
    }

    public String getSize() {
        return Size;
    }
    
    
   

}
