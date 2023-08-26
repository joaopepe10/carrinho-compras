package br.com.improving.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormataReal {
	static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");
	public static String bigDecimalToString(BigDecimal valor){
		return formatandoValores.format(valor);
	}
}
