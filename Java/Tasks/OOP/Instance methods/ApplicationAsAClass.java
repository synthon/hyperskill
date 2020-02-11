class Application {
    
    String name;
 
    public void run(String[] args) {
        System.out.println(name);
        
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
