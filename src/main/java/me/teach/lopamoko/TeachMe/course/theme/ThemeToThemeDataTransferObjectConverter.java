package me.teach.lopamoko.TeachMe.course.theme;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ThemeToThemeDataTransferObjectConverter {
    public ThemeDataTransferObject convert(Theme theme){
        return new ThemeDataTransferObject();
    }
}
