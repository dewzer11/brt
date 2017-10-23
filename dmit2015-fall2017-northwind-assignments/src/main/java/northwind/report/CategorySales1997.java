package northwind.report;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CategorySales1997 {

		private String categoryName;
		private BigDecimal totalSales;
		
		
		public CategorySales1997(String categoryName, BigDecimal totalSales) {
			super();
			this.categoryName = categoryName;
			this.totalSales = totalSales;
		}
		
		public CategorySales1997(String categoryName, double totalSales) {
			super();
			this.categoryName = categoryName;
			this.totalSales = BigDecimal.valueOf(totalSales).setScale(2, RoundingMode.HALF_UP);
		}
		

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public BigDecimal getTotalSales() {
			return totalSales;
		}

		public void setTotalSales(BigDecimal totalSales) {
			this.totalSales = totalSales;
		}
}
