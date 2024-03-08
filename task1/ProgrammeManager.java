package task1;

//import java.util.ArrayList;
import task1.data.DataLoader;
//import task1.data.DataParser;

public class ProgrammeManager {
    public void start(){
        DataLoader loadFile = DataLoader.getLoaderInstance();
        loadFile.readLines();
//        public void start() {
//            DataLoader loadFile = new DataLoader();
//            ArrayList<String> dataBlocks = loadFile.readLines();
//    //        for (String value : dataBlocks) {
//    //            System.out.println(value);
//    //        }
//            dataBlocks.forEach(value -> {
//    //            System.out.println(value);
//                DataParser parseData = new DataParser(value);
//                System.out.println(parseData.extractYear());
//            });
//    //        System.out.println(dataBlocks);
//        }
    }
}
