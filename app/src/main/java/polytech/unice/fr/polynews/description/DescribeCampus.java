package polytech.unice.fr.polynews.description;

/**
 * Created by cesar on 16/04/2016.
 */
public enum DescribeCampus {
    TEMPLIER("C:\\Users\\cesar\\Documents\\PolyAcademie\\app\\src\\main\\res\\drawable\\templier.png", "C:\\Users\\cesar\\Documents\\PolyAcademie\\app\\src\\main\\res\\values\\Desciption_Templier.xml"),
    CANTINE("C:\\Users\\cesar\\Documents\\PolyAcademie\\app\\src\\main\\res\\drawable\\templier.png", "C:\\Users\\cesar\\Documents\\PolyAcademie\\app\\src\\main\\res\\values\\Desciption_Templier.xml"),
    LEARNING("C:\\Users\\cesar\\Documents\\PolyAcademie\\app\\src\\main\\res\\drawable\\templier.png","C:\\Users\\cesar\\Documents\\PolyAcademie\\app\\src\\main\\res\\values\\Desciption_Templier.xml");


    String text;
    String path;


    public String getText(){
        return text;
    }

    DescribeCampus(String path, String textPath){
        this.path = path;
        text =textPath;


    }
    @Override
    public String toString(){
        return text + path;
    }
}
