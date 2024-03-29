package com.example.todolist.SupClass;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Todo type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Todos")
public final class Todo implements Model {
    public static final QueryField ID = field("id");
    public static final QueryField NAME = field("name");
    public static final QueryField DESCRIPTION = field("description");
    private final @ModelField(targetType="ID", isRequired = true) String id;
    private final @ModelField(targetType="String", isRequired = true) String name;
    private final @ModelField(targetType="String") String description;
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Todo(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if(obj == null || getClass() != obj.getClass()) {
            return false;
        } else {
            Todo todo = (Todo) obj;
            return ObjectsCompat.equals(getId(), todo.getId()) &&
                    ObjectsCompat.equals(getName(), todo.getName()) &&
                    ObjectsCompat.equals(getDescription(), todo.getDescription());
        }
    }

    @Override
    public int hashCode() {
        return new StringBuilder()
                .append(getId())
                .append(getName())
                .append(getDescription())
                .toString()
                .hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Todo {")
                .append("id=" + String.valueOf(getId()) + ", ")
                .append("name=" + String.valueOf(getName()) + ", ")
                .append("description=" + String.valueOf(getDescription()))
                .append("}")
                .toString();
    }

    public static NameStep builder() {
        return new Builder();
    }


    public static Todo justId(String id) {
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
            throw new IllegalArgumentException(
                    "Model IDs must be unique in the format of UUID. This method is for creating instances " +
                            "of an existing object with only its ID field for sending as a mutation parameter. When " +
                            "creating a new object, use the standard builder method and leave the ID field blank."
            );
        }
        return new Todo(
                id,
                null,
                null
        );
    }

    public CopyOfBuilder copyOfBuilder(String name,String description) {
        return new CopyOfBuilder(id,
                name,
                description);
    }


    public interface NameStep {
        BuildStep name(String name);
    }


    public interface BuildStep {
        Todo build();
        BuildStep id(String id) throws IllegalArgumentException;
        BuildStep description(String description);
    }


    public static class Builder implements NameStep, BuildStep {
        private String id;
        private String name;
        private String description;
        @Override
        public Todo build() {
            String id = this.id != null ? this.id : UUID.randomUUID().toString();

            return new Todo(
                    id,
                    name,
                    description);
        }

        @Override
        public BuildStep name(String name) {
            Objects.requireNonNull(name);
            this.name = name;
            return this;
        }

        @Override
        public BuildStep description(String description) {
            this.description = description;
            return this;
        }

        /**
         * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
         * This should only be set when referring to an already existing object.
         * @param id id
         * @return Current Builder instance, for fluent method chaining
         * @throws IllegalArgumentException Checks that ID is in the proper format
         */
        public BuildStep id(String id) throws IllegalArgumentException {
            this.id = id;

            try {
                UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
            } catch (Exception exception) {
                throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                        exception);
            }

            return this;
        }
    }


    public final class CopyOfBuilder extends Builder {
        private CopyOfBuilder(String id, String name, String description) {
            super.id(id);
            super.name(name)
                    .description(description);
        }

        @Override
        public CopyOfBuilder name(String name) {
            return (CopyOfBuilder) super.name(name);
        }

        @Override
        public CopyOfBuilder description(String description) {
            return (CopyOfBuilder) super.description(description);
        }
    }

}

