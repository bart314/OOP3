package decorator;

public class Serialize extends EncryptionDecorator  {
    Encryptable text;


    public Serialize(Encryptable txt) {
        super(txt);
        this.text = txt;

    }

    @Override
    public String getData() {
        String tmp = super.getData();
        return String.format("Serialized (%s)", tmp);
    }

    @Override
    String showDecriptedData() {
        return null;
    }


}
