package com.snapdeal.hack.model.neo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailedNeoResponse implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3180221792859651500L;

	private List<String> columns = new ArrayList<String>();

    private List<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

}
