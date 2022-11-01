java_binary (
    name = "BazelApp",
    srcs = glob(["java/**/*.java"]),
    main_class = "example.Main",
    deps = [
      "@maven//:javax_annotation_javax_annotation_api",
      "@maven//:org_projectlombok_lombok",
      "@maven//:com_orientechnologies_orientdb_core",
      "@maven//:com_orientechnologies_orientdb_client",
      "@maven//:com_orientechnologies_orientdb_object",
      "@maven//:com_orientechnologies_orientdb_graphdb"
    ],
    visibility = ["//visibility:public"],
)
