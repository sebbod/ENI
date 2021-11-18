package fr.eni.bids.dal.jdbc;

public class SQL_QUERY {

	public static final String USER_GET_BY_ID = "SELECT [id]\r\n" + "      ,[pseudo]\r\n" + "      ,[name]\r\n"
			+ "      ,[firstName]\r\n" + "      ,[email]\r\n" + "      ,[telephone]\r\n" + "      ,[street]\r\n"
			+ "      ,[zipCode]\r\n" + "      ,[town]\r\n" + "      ,[pwd]\r\n" + "      ,[credit]\r\n"
			+ "      ,[isAdmin]\r\n" + "  FROM [dbo].[USERS]\r\n" + "  WHERE [id] =?;";

	public static final String SQL_INSERT_USER = "INSERT INTO utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur)  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	public static final String SQL_SELECT_USER_BY_EMAIL = "SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM utilisateurs WHERE email=?;";

	public static final String SQL_UPDATE_USER = "UPDATE utilisateurs SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur=?";

	public static final String SQL_SELECT_ALL_EC_ARTICLES = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN UTILISATEURS as u\r\n" + "ON a.no_utilisateur = u.no_utilisateur\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n" + "WHERE a.etat_vente = 'EC'";

	public static final String SQL_SELECT_EC_ARTICLES_BY_KEYWORD = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN UTILISATEURS as u\r\n" + "ON a.no_utilisateur = u.no_utilisateur\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n"
			+ "WHERE a.etat_vente = 'EC' AND a.nom_article LIKE CONCAT( '%',?,'%');";

	public static final String SQL_SELECT_EC_ARTICLES_BY_CATEGORY = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN UTILISATEURS as u\r\n" + "ON a.no_utilisateur = u.no_utilisateur\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n"
			+ "WHERE a.etat_vente = 'EC' AND a.no_categorie = ?;";

	public static final String SQL_SELECT_EC_ARTICLES_BY_KEYWORD_AND_CATEGORY = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN UTILISATEURS as u\r\n" + "ON a.no_utilisateur = u.no_utilisateur\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n"
			+ "WHERE a.etat_vente = 'EC' AND a.no_categorie = ? AND a.nom_article LIKE CONCAT( '%',?,'%');";

	public static final String SQL_SELECT_USER_BIDS_ARTICLES = "SELECT * FROM articles_vendus as a INNER JOIN ENCHERES as e ON a.no_article = e.no_article INNER JOIN UTILISATEURS as u ON a.no_utilisateur = u.no_utilisateur INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie WHERE a.etat_vente = 'EC' AND e.no_utilisateur = ?;";

	public static final String SQL_SELECT_USER_BIDS_ARTICLES_BY_KEYWORD = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN ENCHERES as e\r\n" + "ON a.no_article = e.no_article\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n"
			+ "INNER JOIN UTILISATEURS as u ON a.no_utilisateur = u.no_utilisateur WHERE a.etat_vente = 'EC' AND e.no_utilisateur = ? AND a.nom_article LIKE CONCAT( '%',?,'%');";

	public static final String SQL_SELECT_USER_BIDS_ARTICLES_BY_CATEGORY = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN ENCHERES as e\r\n" + "ON a.no_article = e.no_article\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n"
			+ "INNER JOIN UTILISATEURS as u ON a.no_utilisateur = u.no_utilisateur WHERE a.etat_vente = 'EC' AND e.no_utilisateur = ? AND a.no_categorie = ?;";

	public static final String SQL_SELECT_USER_BIDS_ARTICLES_BY_KEYWORD_AND_CATEGORY = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN ENCHERES as e\r\n" + "ON a.no_article = e.no_article\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n"
			+ "INNER JOIN UTILISATEURS as u ON a.no_utilisateur = u.no_utilisateur WHERE a.etat_vente = 'EC' AND e.no_utilisateur = ? AND a.no_categorie = ? AND a.nom_article LIKE CONCAT( '%',?,'%');";

	public static final String SQL_SELECT_WON_BIDS_ARTICLES = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN ENCHERES as e\r\n" + "ON a.no_article = e.no_article\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n"
			+ "INNER JOIN UTILISATEURS as u ON a.no_utilisateur = u.no_utilisateur WHERE (a.etat_vente = 'VD' OR a.etat_vente = 'RT') AND e.no_utilisateur = ? AND e.montant_enchere = a.prix_vente;";

	public static final String SQL_SELECT_WON_BIDS_ARTICLES_BY_KEYWORD = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN ENCHERES as e\r\n" + "ON a.no_article = e.no_article\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n"
			+ "INNER JOIN UTILISATEURS as u ON a.no_utilisateur = u.no_utilisateur WHERE (a.etat_vente = 'VD' OR a.etat_vente = 'RT') AND e.no_utilisateur = ? AND a.nom_article LIKE CONCAT( '%',?,'%') AND e.montant_enchere = a.prix_vente;";

	public static final String SQL_SELECT_WON_BIDS_ARTICLES_BY_CATEGORY = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN ENCHERES as e\r\n" + "ON a.no_article = e.no_article\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n"
			+ "INNER JOIN UTILISATEURS as u ON a.no_utilisateur = u.no_utilisateur WHERE (a.etat_vente = 'VD' OR a.etat_vente = 'RT') AND e.no_utilisateur = ? AND a.no_categorie = ? AND e.montant_enchere = a.prix_vente;";

	public static final String SQL_SELECT_WON_BIDS_ARTICLES_BY_KEYWORD_AND_CATEGORY = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN ENCHERES as e\r\n" + "ON a.no_article = e.no_article\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n"
			+ "INNER JOIN UTILISATEURS as u ON a.no_utilisateur = u.no_utilisateur WHERE (a.etat_vente = 'VD' OR a.etat_vente = 'RT') AND e.no_utilisateur = ? AND a.no_categorie = ? AND a.nom_article LIKE CONCAT( '%',?,'%') AND e.montant_enchere = a.prix_vente;";

	public static final String SQL_SELECT_USER_SALES = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n"
			+ "INNER JOIN UTILISATEURS as u ON a.no_utilisateur = u.no_utilisateur WHERE u.pseudo = ? AND a.etat_vente = ?";

	public static final String SQL_SELECT_USER_SALES_BY_KEYWORD = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n"
			+ "INNER JOIN UTILISATEURS as u ON a.no_utilisateur = u.no_utilisateur WHERE u.pseudo = ? AND a.etat_vente = ? AND a.nom_article LIKE CONCAT( '%',?,'%')";

	public static final String SQL_SELECT_USER_SALES_BY_CATEGORY = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n"
			+ "INNER JOIN UTILISATEURS as u ON a.no_utilisateur = u.no_utilisateur WHERE u.pseudo = ? AND a.etat_vente = ? AND a.no_categorie = ?";

	public static final String SQL_SELECT_USER_SALES_BY_KEYWORD_AND_CATEGORY = "SELECT * FROM articles_vendus as a\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n"
			+ "INNER JOIN UTILISATEURS as u ON a.no_utilisateur = u.no_utilisateur WHERE u.pseudo = ? AND a.etat_vente = ? AND a.no_categorie = ? AND a.nom_article LIKE CONCAT( '%',?,'%')";

	public static final String SQL_DISABLE_USER = "UPDATE UTILISATEURS SET ACTIF = 0 WHERE pseudo=?";

	public static final String SQL_INSERT_ARTICLE = "INSERT INTO articles_vendus(nom_article, description, date_debut_enchere, "
			+ "date_fin_enchere, prix_initial, no_utilisateur, no_categorie, etat_vente) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String SQL_UPDATE_ARTICLE = "UPDATE articles_vendus SET nom_article = ?, description = ?, date_debut_enchere = ?, "
			+ "date_fin_enchere = ?, prix_initial = ?, no_categorie = ?, etat_vente = ? WHERE no_article = ?";

	public static final String SQL_INSERT_PICKUP = "INSERT INTO retraits(no_article, rue, code_postal, ville) VALUES (?, ?, ?, ?)";

	public static final String SQL_DELETE_ARTICLE = "DELETE FROM articles_vendus WHERE no_article = ?";

	public static final String SQL_SELECT_ARTICLE_BY_ID = "SELECT * FROM ARTICLES_VENDUS as a \r\n"
			+ "INNER JOIN UTILISATEURS as u ON u.no_utilisateur = a.no_utilisateur\r\n"
			+ "INNER JOIN CATEGORIES as c on a.no_categorie = c.no_categorie\r\n" + "WHERE a.no_article = ?;";

	public static final String SQL_SELECT_POINTS_BY_USER = "SELECT credit FROM utilisateurs WHERE no_utilisateur=?;";

	public static final String SQL_CREATE_BID = "INSERT INTO encheres (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES (?, ?, ?, ?);";

	public static final String SQL_UPDATE_SELL_PRICE = "UPDATE articles_vendus SET prix_vente = ? WHERE no_article = ?";

	public static final String SQL_SELECT_BID = "SELECT * FROM ENCHERES WHERE no_utilisateur = ? AND no_article = ?;";

	public static final String SQL_UPDATE_BID = "UPDATE encheres SET montant_enchere = ?, date_enchere = ? WHERE no_utilisateur = ? AND no_article = ?;";

	public static final String SQL_UPDATE_PICKUP = "UPDATE retraits SET rue = ?, code_postal = ? , ville = ? WHERE no_article = ? ";

	public static final String SQL_SELECT_PICKUP_BY_ID = "SELECT * FROM retraits WHERE no_article=?";

	public static final String SQL_UPDATE_CREDIT = "UPDATE utilisateurs SET credit = ? WHERE no_utilisateur = ?";

	public static final String SQL_SELECT_ARTICLE_MAX_BID = "SELECT prix_vente FROM articles_vendus WHERE no_article = ?;";
	public static final String SQL_SELECT_BID_BY_ARTICLE_AND_AMOUNT = "SELECT * FROM encheres WHERE no_article = ? AND montant_enchere = ?;";
	public static final String SQL_SELECT_USER_BY_ID = "SELECT * FROM utilisateurs WHERE no_utilisateur = ?;";

	public static final String SQL_SELECT_USER_MAX_BID = "SELECT * FROM articles_vendus as a \r\n"
			+ "INNER JOIN ENCHERES as e ON a.no_article = e.no_article \r\n"
			+ "INNER JOIN utilisateurs as u ON e.no_utilisateur = u.no_utilisateur \r\n"
			+ "WHERE e.montant_enchere = a.prix_vente AND a.no_article = ?;";

}
