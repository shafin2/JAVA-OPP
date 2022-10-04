public class PC {    
    
    private String AssetID;
    private String ItemName;
    private String CPUSerialNo;
    private int RAMSizeMB;
    private int HardDiskSizeGB;
    private Boolean GPU;
    public PC(String assetID, String itemName, String cPUSerialNo, int rAMSizeMB, int hardDiskSizeGB, Boolean gPU) {
        AssetID = assetID;
        ItemName = itemName;
        CPUSerialNo = cPUSerialNo;
        RAMSizeMB = rAMSizeMB;
        HardDiskSizeGB = hardDiskSizeGB;
        GPU = gPU;
    }
    PC(PC obj){
        this.AssetID=obj.AssetID;
        this.ItemName=obj.ItemName;
        this.CPUSerialNo=obj.CPUSerialNo;
        this.RAMSizeMB=obj.RAMSizeMB;
        this.HardDiskSizeGB=obj.HardDiskSizeGB;
        this.GPU=obj.GPU;
    }
    public String getAssetID() {
        return AssetID;
    }
    public void setAssetID(String assetID) {
        AssetID = assetID;
    }
    public String getItemName() {
        return ItemName;
    }
    public void setItemName(String itemName) {
        ItemName = itemName;
    }
    public String getCPUSerialNo() {
        return CPUSerialNo;
    }
    public void setCPUSerialNo(String cPUSerialNo) {
        CPUSerialNo = cPUSerialNo;
    }
    public int getRAMSizeMB() {
        return RAMSizeMB;
    }
    public void setRAMSizeMB(int rAMSizeMB) {
        RAMSizeMB = rAMSizeMB;
    }
    public int getHardDiskSizeGB() {
        return HardDiskSizeGB;
    }
    public void setHardDiskSizeGB(int hardDiskSizeGB) {
        HardDiskSizeGB = hardDiskSizeGB;
    }
    public Boolean getGPU() {
        return GPU;
    }
    public void setGPU(Boolean gPU) {
        GPU = gPU;
    }
    @Override
    public boolean equals(Object obj) {
        PC p1=(PC)obj;
        boolean equal=false;
        if(this.AssetID==p1.AssetID){
            equal=true;
        }
        return equal;
    }
    public Object clone(){
        Object temp=new PC(this.AssetID, this.ItemName, this.CPUSerialNo, this.RAMSizeMB, this.HardDiskSizeGB, this.GPU);
        return temp;
    }
    @Override
    public String toString() {
        return "PC [AssetID=" + AssetID + ", CPUSerialNo=" + CPUSerialNo + ", GPU=" + GPU + ", HardDiskSizeGB="
                + HardDiskSizeGB + ", ItemName=" + ItemName + ", RAMSizeMB=" + RAMSizeMB + "]";
    }
}
