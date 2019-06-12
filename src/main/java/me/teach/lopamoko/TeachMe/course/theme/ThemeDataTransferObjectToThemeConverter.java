package me.teach.lopamoko.TeachMe.course.theme;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ThemeDataTransferObjectToThemeConverter {

    public Theme convert(ThemeDataTransferObject themeDataTransferObject) {
        return new Theme();
    }
}
