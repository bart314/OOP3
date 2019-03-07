package state;

/*
De interface State. Hierin staat de *volledige* interactie gedefinieerd die onze cola-machine aankan. Elke state
moet deze interface implementeren, omdat de machine in elke state moet kunnen reageren op elke mogelijke interactie.
Wat er met de machine gebeurt, is afhankelijk van de status op dat moment, dus wordt beschreven in de concrete
state-klasse.

De machine kent momenteel naast een StartState drie andere statussen. Om wildgroei in deze package tegen te gaan,
en omdat het wellicht wat duidelijk is, heb ik deze allemaal in hetzelfde bestand gezet (daarom ontbreekt ook de
visibility modifier bij de klasse-definities). De states spreken verder redelijk voor zichzelf.
*/

public interface State {
	
	void insertFiftyCents(ColaMachine context);
	void insertOneEuro(ColaMachine context);

}

class StartState implements State {

	@Override
	public void insertFiftyCents(ColaMachine context) {
		context.setState(new State1());
		context.giveStatus("Saldo: 50 cent.");
	}

	@Override
	public void insertOneEuro(ColaMachine context) {
		context.setState(new State2());
		context.giveStatus("Saldo: 1 euro.");
	}
}


class State1 implements State {

	@Override
	public void insertFiftyCents(ColaMachine context) {
		context.setState(new State2());
		context.giveStatus("Saldo: 1 euro.");
	}

	@Override
	public void insertOneEuro(ColaMachine context) {
		context.setState(new State3());
		context.giveStatus("Saldo: 1,50 euro");
	}
}


class State2 implements State {

	@Override
	public void insertFiftyCents(ColaMachine context) {
		context.setState(new State3());
		context.giveStatus("Saldo: 1,50 euro");
	}

	@Override
	public void insertOneEuro(ColaMachine context) {
		context.giveCola();
		context.setState(new StartState());
	}
}


class State3 implements State {

	@Override
	public void insertFiftyCents(ColaMachine context) {
		context.giveCola();
		context.setState(new StartState());
	}

	@Override
	public void insertOneEuro(ColaMachine context) {
		context.returnMoney(50);
		context.giveCola();
		context.setState(new StartState());
	}
	
}
