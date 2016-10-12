package gofmodel.Facade;

/**
 * 基金
 * @author Administrator
 *
 */
public class Fund {
	
   private Shares shares; //股票
   private ForeignCurrency foreignCurrency; //外汇
   private PreciousMetal preciousMetal; //贵金属
   
   public Fund(){
	   shares = new Shares();
	   foreignCurrency = new ForeignCurrency();
	   preciousMetal = new PreciousMetal();
   }
   
   
   //高风险型
   public void highrisk(){
	   shares.transaction();
   }
   
   //稳健型
   public void strong(){
	   foreignCurrency.transaction();
	   preciousMetal.transaction();
   }
	
}
