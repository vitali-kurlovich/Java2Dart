package org.java2dart.schema.method;

import org.java2dart.schema.modifier.Accesable;
import org.java2dart.schema.modifier.Modifible;
import org.java2dart.schema.varible.Parameter;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;


public interface IExecutable extends Accesable, Modifible {

    @NonNull TypeDescription getReturnType();

    @Nullable List<Parameter> getArguments();
}
