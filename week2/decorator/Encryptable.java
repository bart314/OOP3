package decorator;

/*
Deze interface wordt gebruikt door de verschillende decorators. Zowel als
implementatie als in een veld (is-a en has-a relationships).
Deze specifieke interface is natuurlijk super-eenvoudig, maar je kunt je
eenvoudig voorstellen dat het een wat complexere situatie modelleert.
 */

interface Encryptable {
	public String getData();
}
