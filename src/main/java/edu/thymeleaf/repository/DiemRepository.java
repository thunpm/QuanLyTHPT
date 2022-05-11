package edu.thymeleaf.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.thymeleaf.model.Diem;

public interface DiemRepository extends JpaRepository<Diem, String> {
	Diem getDiemByMaHSAndMaPC(String maHS, String maPC);
	
	@Transactional
	@Modifying
	@Query(value = "update Diem d set d.DiemHe1 = ?2, d.DiemHe2 = ?3, d.DiemHe3 = ?4 where d.MaDiem = ?1", nativeQuery = true)
	void updateDiem(String maDiem, float diemHe1, float diemHe2, float diemHe3);

	@Query(value = "call DanhSachDiem(:id);", nativeQuery = true)
	List<Diem> getListNewByMaGV(String id);

}	
