package com.test.selector;

import com.test.dao.TestImportDao;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MySelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{TestImportDao.class.getName()};
	}
}
