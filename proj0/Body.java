public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	/** Constructors */
	public Body(double xP, double yP, double xV,
				double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	/** Second constructors */
	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	/** Method to calculate distance. */
	public double calcDistance(Body b) {
		double xxDif = this.xxPos - b.xxPos;
		double yyDif = this.yyPos - b.yyPos;
		return Math.sqrt(xxDif*xxDif + yyDif*yyDif);
	}

	/** Method to calculate force exerted on give Body. */
	public double calcForceExertedBy(Body b) {
		double rr = this.calcDistance(b);
		double gg = 6.67 * Math.pow(10,-11);
		double force = gg * this.mass * b.mass/Math.pow(rr,2);
		return force;
	}
}