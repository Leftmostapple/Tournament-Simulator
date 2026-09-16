import java.util.Random;
public class NameGenerator {
    Random random = new Random();

    String[] fNames = {"Adela", "Adelaide", "Adelheid", "Aelfthryth", "Aelric", "Aethelflaed", "Aethelred",
            "Aldemar", "Aldric", "Aldric", "Alaric", "Alice", "Alix", "Alys", "Amice", "Aoife", "Astrid", "Aubrey", "Aurelius", "Avice", "Avice",
            "Baldwin", "Beatrice", "Berengaria", "Bertram", "Bjorn", "Blanche", "Brannoc",
            "Cadell", "Cecily", "Cecily", "Clarice", "Conrad", "Cuthbert", "Dietrich", "Drogo",
            "Mahaut", "Marcus", "Margery", "Matilda", "Maud", "Milo",
            "Ragnar", "Ralph", "Reginald", "Robert", "Roger", "Rohesia", "Rosamund"};

    String[] lNames = {"de Warenne", "FitzAlan", "Godwinson", "de Clare", "de Braose", "de Bohun",
            "de Vere", "Mortimer", "Marshal", "de Lusignan", "de Montfort", "de Neville", "de Beauchamp", "de Courtenay", "de Ferrers", "de Mowbray",
            "de Percy", "de Roos", "de Vesci", "de Quincy", "de Lacy", "Lovel", "Talbot", "Audley", "Berkeley",
            "Bigod", "Basset", "Giffard", "Harcourt", "Hastings", "Malet", "Marmion", "Somerville",
            "Stonor", "Swinford", "Taverner", "Tostig", "Trenchard", "Turville", "Vernon", "Waleran", "Waltham", "Warde", "Waryn", "Wenlock"};

    private final String firstName;
    private final String lastName;

    public NameGenerator(){
        this.firstName = fNames[random.nextInt(fNames.length)];
        this.lastName = lNames[random.nextInt(lNames.length)];
    }

    public String getFullName(){
        String fullName;
        return fullName = firstName + " " + lastName;
    }
}
