public class Light implements Device{
    private boolean mode = false;
    @Override
    public void operate() {
        if(mode){
            System.out.println("The light is turned on.");

        }else{
            System.out.println("The light is turned off.");
        }
        mode = !mode;
    }

}
