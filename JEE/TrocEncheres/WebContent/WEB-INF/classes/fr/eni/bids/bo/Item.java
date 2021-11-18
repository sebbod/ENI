package fr.eni.bids.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Article implements Serializable {

	private static final long serialVersionUID = -4813349171372997274L;

	private Integer id;
	private String name;
	private String description;
	private LocalDateTime bidStartDate;
	private LocalDateTime bidEndDate;
	private int startingBid;
	private int salePrice;
	private String status;
	private int idCategory;
	private int idUser;
	private User user;
	private Category category;


}
