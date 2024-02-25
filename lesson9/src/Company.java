public class Company {
    private int companySize = 10;
    private static Workers[] workers;
    private static int len;
    Company(){
        workers = new Workers[companySize];
    }
    public void add(Workers worker){
        if (len < companySize) {
            workers[len] = worker;
            len++;
        }else {
            System.out.println("error, too many worker");
        }
    }
    public void remove(String name){
        for (int i = 0; i < len; i++) {
            if (name.equals(workers[i].getName())){
                workers[i] = null;
            }
        }
        clear();
        len--;
    }
    private void clear(){
        Workers[] workers2;
        workers2 = new Workers[companySize];
        int index = 0;
        for (int i = 0; i < workers.length; i++){
            if (workers[i] != null){
                workers2[index] = workers[i];
                index += 1;
            }
        }
        this.workers = workers2;
    }
    public void sumSalary(){
        int sum = 0;
        for (int i = 0; i < len; i++){
            sum += workers[i].getSalary();
        }
        System.out.println(sum);
    }
    public static void mid(){
        int sum = 0;
        for (int i = 0; i < len; i++){
            sum += workers[i].getSalary();
        }
        System.out.println(sum/len);
    }
}
