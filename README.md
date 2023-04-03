### Hexlet tests and linter status:
[![Actions Status](https://github.com/EvaOrdo/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/EvaOrdo/java-project-78/actions)
<a href="https://codeclimate.com/github/EvaOrdo/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/384b8fae59b436c3c166/maintainability" /></a>
<a href="https://codeclimate.com/github/EvaOrdo/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/384b8fae59b436c3c166/test_coverage" /></a>
[![build](https://github.com/EvaOrdo/java-project-78/actions/workflows/build.yml/badge.svg)](https://github.com/EvaOrdo/java-project-78/actions/workflows/build.yml)


## Data Validator
Java library Data validator is a schema builder for runtime value parsing and validation. Define a schema and check if a value matches. Test function isValid returns true or false depending on the whether the check passed. It can be used for String, Integer and Map objects.

### Getting Started
#### StringSchema

```

import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

Validator v = new Validator();

StringSchema schema = v.string();

schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true
schema.isValid(null); // false
schema.isValid(5); // false
schema.isValid(""); // false

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false

```

#### NumberSchema

```
import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;

Validator v = new Validator();

NumberSchema schema = v.number();

schema.isValid(null); // true
schema.positive().isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(10) // true
schema.isValid("5"); // false
schema.isValid(-10); // false
schema.isValid(0); // false

schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false

```

#### MapSchema

```
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;

Validator v = new Validator();

MapSchema schema = v.map();

schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(new HashMap()); // true
Map<String, String> data = new HashMap<>();
data.put("key1", "value1");
schema.isValid(data); // true

schema.sizeof(2);

schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true

```

#### Inner validation for Map<?, ?> objects
shape method allows to add a set of requirements for Map objects values by the keys

```
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();

MapSchema schema = v.map();

Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());
schema.shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Hannah");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "Maya");
human2.put("age", null);
schema.isValid(human2); // true

Map<String, Object> human3 = new HashMap<>();
human3.put("name", "");
human3.put("age", null);
schema.isValid(human3); // false

Map<String, Object> human4 = new HashMap<>();
human4.put("name", "Jane");
human4.put("age", -5);
schema.isValid(human4); // false

```
