public class Planet{
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;
  public static final double g=6.67e-11;
  public Planet(double xP, double yP, double xV,
                double yV, double m, String img){
                  xxPos=xP;
                  yyPos=yP;
                  xxVel=xV;
                  yyVel=yV;
                  mass=m;
                  imgFileName=img;
                }
  public Planet(Planet p){
    xxPos=p.xxPos;
    yyPos=p.yyPos;
    xxVel=p.xxVel;
    yyVel=p.yyVel;
    mass=p.mass;
    imgFileName=p.imgFileName;
  }
  public double calcDistance(Planet p){
    double dist=Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos)+
    (yyPos-p.yyPos)*(yyPos-p.yyPos));
    return dist;
  }
  public double calcForceExertedBy(Planet p){
    double forc=(g*mass*p.mass)/(this.calcDistance(p)*this.calcDistance(p));
    return forc;
  }
  public double calcForceExertedByX(Planet p){
    double forcX=(this.calcForceExertedBy(p)*(p.xxPos-xxPos))/
    this.calcDistance(p);
    return forcX;
  }
  public double calcForceExertedByY(Planet p){
    double forcY=(this.calcForceExertedBy(p)*(p.yyPos-yyPos))/
    this.calcDistance(p);
    return forcY;
  }
  public double calcNetForceExertedByX(Planet[] allPlanets){
    double NetForcX=0;
    for(int i=0;i<allPlanets.length;i+=1){
      if(this.equals(allPlanets[i])){
        continue;
      }else{
        NetForcX +=this.calcForceExertedByX(allPlanets[i]);
      }
    }
    return NetForcX;
  }
  public double calcNetForceExertedByY(Planet[] allPlanets){
    double NetForcY=0;
    for(int i=0;i<allPlanets.length;i+=1){
      if(this.equals(allPlanets[i])){
        continue;
      }else{
        NetForcY +=this.calcForceExertedByY(allPlanets[i]);
      }
    }
    return NetForcY;
  }
  public void update(double dt,double fX,double fY){
    double accX=fX/mass;
    double accY=fY/mass;
    xxVel=xxVel+accX*dt;
    yyVel=yyVel+accY*dt;
    xxPos=xxPos+xxVel*dt;
    yyPos=yyPos+yyVel*dt;
  }
  public void draw(){
    StdDraw.picture(xxPos,yyPos , "images/"+imgFileName);
  }





























}
