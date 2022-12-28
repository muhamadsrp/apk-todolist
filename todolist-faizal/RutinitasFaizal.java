
public class RutinitasFaizal {
    public static String[] data = new String[5];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {

        viewShowRutinitas();
    }
    /**
     * Menampilkan Rutinitas
     */
    public static void showRutinitas(){
        System.out.println("RUTINITAS");
        for (int i = 0; i < data.length; i++) {
            var rutinitas = data[i];
            var no = i +1;

            if (data[i] != null){
                System.out.println(no+ ". " + rutinitas);
            }
        }
    }
    /**
     *Menambahkan Rutinitas
     */
    public static void addRutinitas(String rutinitas){
        //Resize
        var isFull = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null){
                isFull = false;
            }
        }
        if (isFull){
            var tempo = data;
            data = new String[data.length * 2];

            for (int i = 0; i < tempo.length; i++) {
                data[i] = tempo[i];
            }
        }
        //Menambahkan data ke array NULL
        for (int i = 0; i < data.length; i++) {
            if(data[i] == null){
                data[i] = rutinitas;
                break;
            }
        }
    }
    /**
     *Menghapus Rutinitas
     */
    public static boolean removeRutinitas(int numb){
        if ((numb - 1) >= data.length){
            return false;
        } else if (data[numb-1] == null) {
            return false;
        } else {
            for (int i = (numb-1); i < data.length; i++) {
                if (i == (data.length) - 1){
                    data[i] = null;
                }else{
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }

    /**
     * Inputan
     */
    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    /**
     * Menampilkan hasil Rutinitas
     */
    public static void viewShowRutinitas(){
        while (true){
            showRutinitas();

            System.out.println("MENU");
            System.out.println("1. Tambah Rutinitas");
            System.out.println("2. Hapus Rutinitas");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            if (input.equals("1")){
                viewAddRutinitas();
            } else if (input.equals("2")) {
                viewRemoveRutinitas();
            } else if (input.equals("x")){
                break;
            } else {
                System.out.println("Piliahn Tidak Ada!!");
            }
        }
        }
    public static void viewAddRutinitas(){
        System.out.println("MENAMBAHKAN RUTINITAS");

        var rutinitas = input("Rutinitas (x Jika Batal)");

        if (rutinitas.equals("x")){
            //Batal
        } else {
            addRutinitas(rutinitas);
        }
    }
    public static void viewRemoveRutinitas(){
        System.out.println("MENGHAPUS RUTINITAS");

        var numb = input("Nomor menghapus Rutinitas (X Jika Batal)");

        if (numb.equals("x")){
            //Batal
        } else {
            boolean succes = removeRutinitas(Integer.valueOf(numb));
            if (!succes){
                System.out.println("Gagal Menghapus Rutinitas!!");
            }
        }
    }
//    public static void viewRemoveRutinitas(){
//        System.out.println("(x) Jika Batal");
//
//        var input = input("Pilih");
//
//        if (input.equals("x")){
//            viewShowRutinitas();
//        } else {
//        }
//    }
}