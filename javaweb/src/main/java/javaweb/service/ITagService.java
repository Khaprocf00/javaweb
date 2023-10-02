package javaweb.service;

import java.util.List;

import javaweb.model.TagModel;
import javaweb.paging.Pageble;

public interface ITagService {
	Long insert(TagModel brand);

	void update(TagModel brand, Long id);

	void delete(Long[] ids);

	void deleteById(Long id);

	List<TagModel> findAll();

	List<TagModel> findAllPage(Pageble pageble);

	int totalItemInTable();

	boolean checkName(String name);

	TagModel findById(Long id);
}
