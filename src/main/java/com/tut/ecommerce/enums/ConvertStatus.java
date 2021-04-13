package com.tut.ecommerce.enums;

import java.util.Arrays;

/**
 * ENUM PARA EL MANEJO DE LOS ESTADOS DE CARRITO Y ORDEN DE CHECKOUT
 * 
 * @author ferdando.torres
 *
 */
public enum ConvertStatus {

	ACTIVE("777a1a58d-d435-4bf1-a1ba-0c82d5dc7f1"), DISABLED("111d0631-2121-4965-aa4e-9779d5d6fab"),
	PENDING("333p259b7-b358-4045-a65f-57a045e7cf9");

	private final String id;

	ConvertStatus(String string) {
		this.id = string;
	}

	public static String nameFromId(String id) {
		return (String) Arrays.stream(values()).filter((dse) -> {
			return dse.getId().contentEquals(id);
		}).map(Enum::name).findFirst().orElseThrow(() -> {
			return new RuntimeException("OBJECT_STATUS_NOT_VALID");
		});
	}

	public String getId() {
		return this.id;
	}

}
