package com.jotc.nsis;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Joe on 03/03/15 at 22:01.
 * <p/>
 * Requirements: ${REQUIREMENTS}
 */
public class NSISFileTypeFactory extends FileTypeFactory {

    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(NSIFileType.INSTANCE, "nsi");
        fileTypeConsumer.consume(NSHFileType.INSTANCE, "nsh");
    }
}
