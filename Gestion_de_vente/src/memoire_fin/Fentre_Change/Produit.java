package memoire_fin.Fentre_Change;

import com.mysql.jdbc.Blob;


public class Produit {
   
   
   
     
   private int id_type,Internal,RAM,Charging,prix,Announced,quantite,Rear_camera,Selfie_camera;
   private String Name,marque,Build,Protection,CPU,Card_slot,Bluetooth,Network,Sim_size,Sim_multiply,OS,Notch,NFC ,GPS,Flach,Empreint,Colors;
   float size;
   double weight,Bluetooth_serie;
    Blob []image ;
    
   
    
    public Produit() {
          super();
	}
   
    public Produit(int id_type,int quantite,int RAM,int Charging,int Rear_camera,int Selfie_camera ,int prix,int Announced,String Name,String Build,String Protection,String CPU,String Card_slot	
                   ,String Notch,String NFC,String marque,String Bluetooth,String GPS,String Flach,String Empreint,String Colors ,
                   double weight,float size,int Internal,double Bluetooth_serie,Blob []image ) {
		//super();
	   
           this.id_type=id_type;
           this.RAM = RAM;
           this.Charging=Charging;
           this.prix=prix;
           this.Announced=Announced; 
           this.Name=Name;
           this.Build=Build;
           this.Protection=Protection;
           this.CPU=CPU;
           this.Card_slot=Card_slot;
           this.Network=Network;
           this.Sim_size=Sim_size;
           this.Sim_multiply=Sim_multiply;
           this.OS=OS;
           this.Notch=Notch;
           this.NFC= NFC;
           this.GPS=GPS;
           this.Flach=Flach;
           this.Empreint=Empreint;
           this.Bluetooth=Bluetooth;
           this.Colors=Colors;
           this.Bluetooth_serie =Bluetooth_serie;
           this.Rear_camera=Rear_camera;
           this.Selfie_camera=Selfie_camera;
           this.image=image;
           this.quantite =quantite;
           this.marque=marque;
	}

   

    public String getMarque() {
        return marque;
    }
    
    
    public int getAnnounced() {
        return Announced;
    }
    

    public double getBluetooth_serie() {
        return Bluetooth_serie;
    }

    public String getBuild() {
        return Build;
    }

    public String getCPU() {
        return CPU;
    }

    public String getCard_slot() {
        return Card_slot;
    }

    public String getBluetooth() {
        return Bluetooth;
    }
    

    public int getCharging() {
        return Charging;
    }

    public String getColors() {
        return Colors;
    }

    public String getEmpreint() {
        return Empreint;
    }

    public String getFlach() {
        return Flach;
    }

    public String getGPS() {
        return GPS;
    }

    public int getId_type() {
        return id_type;
    }

    public Blob [] getImage() {
        return image;
    }

    public int getInternal() {
        return Internal;
    }

    public String getNFC() {
        return NFC;
    }

    public String getName() {
        return Name;
    }

    public String getNetwork() {
        return Network;
    }

    public String getNotch() {
        return Notch;
    }

    public String getOS() {
        return OS;
    }

    public int getPrix() {
        return prix;
    }

    public String getProtection() {
        return Protection;
    }

    public int getRAM() {
        return RAM;
    }

    public int getRear_camera() {
        return Rear_camera;
    }

    public int getSelfie_camera() {
        return Selfie_camera;
    }
    

    public String getSim_multiply() {
        return Sim_multiply;
    }

    public String getSim_size() {
        return Sim_size;
    }

    public float getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }
    
    
    public void setAnnounced(int Announced) {
        this.Announced = Announced;
    }

    public void setBluetooth_serie(double Bluetooth_serie) {
        this.Bluetooth_serie = Bluetooth_serie;
    }

    public void setBuild(String Build) {
        this.Build = Build;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setBluetooth(String Bluetooth) {
        this.Bluetooth = Bluetooth;
    }
    

    public void setCard_slot(String Card_slot) {
        this.Card_slot = Card_slot;
    }

    public void setCharging(int Charging) {
        this.Charging = Charging;
    }

    public void setColors(String Colors) {
        this.Colors = Colors;
    }

    public void setEmpreint(String Empreint) {
        this.Empreint = Empreint;
    }

    public void setFlach(String Flach) {
        this.Flach = Flach;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public void setRear_camera(int Rear_camera) {
        this.Rear_camera = Rear_camera;
    }

    public void setSelfie_camera(int Selfie_camera) {
        this.Selfie_camera = Selfie_camera;
    }
 
    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public void setImage(Blob[] image) {
        this.image = image;
    }
    


    public void setInternal(int Internal) {
        this.Internal = Internal;
    }

    public void setNFC(String NFC) {
        this.NFC = NFC;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setNetwork(String Network) {
        this.Network = Network;
    }

    public void setNotch(String Notch) {
        this.Notch = Notch;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setProtection(String Protection) {
        this.Protection = Protection;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setSim_multiply(String Sim_multiply) {
        this.Sim_multiply = Sim_multiply;
    }

    public void setSim_size(String Sim_size) {
        this.Sim_size = Sim_size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
     
      
    
    
    

    
    
    
    
    
   
    
    
    
    
    
    
    
    
    
}
