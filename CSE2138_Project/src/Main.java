import javax.sound.midi.Soundbank;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperation();
        //System.out.println(fileOperation.readFile("/Users/omerfarukbulut/Downloads/CSE2138_Project/src/input.txt"));
        HashMap<String, String> data = DetectType.detectType(fileOperation.readFile("src/input.txt"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Byte Ordering: ");
        String byteOrder = scanner.nextLine();
        System.out.println("Floating point size: ");
        int floatSize = scanner.nextInt();
        for (Map.Entry set: data.entrySet()) {

            if (set.getValue()=="unsigned"){
                System.out.println(OrderingType.orderType(BitToHex.bitToHex(IntToBit.unsignedToBit(Integer.parseInt(set.getKey().toString()))),byteOrder.charAt(0)));
            }
            else if(set.getValue()== "int"){
                System.out.println(OrderingType.orderType(BitToHex.bitToHex(IntToBit.signedToBit(Integer.parseInt(set.getKey().toString()))),byteOrder.charAt(0)));
            }
            else if(set.getValue()== "float"){
                System.out.println(OrderingType.orderType(BitToHex.bitToHex(FloatToBinary.lastOperations(set.getKey().toString(),floatSize)),byteOrder.charAt(0)));
            }
        }
        System.out.println(data);
        System.out.println(BitToHex.bitToHex(FloatToBinary.lastOperations("29.109375",floatSize)));

    }
}
