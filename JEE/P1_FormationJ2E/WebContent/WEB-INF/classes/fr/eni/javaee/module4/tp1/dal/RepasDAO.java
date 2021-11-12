package fr.eni.javaee.module4.tp1.dal;

import java.time.LocalDate;
import java.util.List;

import fr.eni.javaee.module4.tp1.BusinessException;
import fr.eni.javaee.module4.tp1.bo.Repas;

public interface RepasDAO {
	public void insert(Repas repas) throws BusinessException;

	public List<Repas> select() throws BusinessException;

	public List<Repas> select(LocalDate dateRecherchee) throws BusinessException;

	public List<Repas> select(int page) throws BusinessException;
}
