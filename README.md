# Project Learnings

## Key Learnings

### Spring Boot
- **Dependency Injection**: Utilized `@Autowired` to inject dependencies.
- **Repositories**: Annotated classes with `@Repository` to make them Spring beans.
- **Transactional Management**: Used `@Transactional` to manage transactions.

### JPA and Hibernate
- **Entity Management**: Managed entities using `EntityManager` with methods like `persist` and `merge`.
- **Annotations**: Correctly used JPA annotations like `@Entity`, `@Table`, `@Id`, `@GeneratedValue`, `@ManyToOne`, `@OneToMany`, and `@ManyToMany` to map relationships.
- **Error Handling**: Resolved common exceptions such as `InvalidDataAccessApiUsageException` and `AnnotationException`.

### Aspect-Oriented Programming (AOP)
- **Aspects**: Created aspects using `@Aspect` and `@Component`.
- **Advice Types**: Implemented different types of advice (`@Before`, `@After`, `@AfterReturning`, `@AfterThrowing`, `@Around`).
- **Pointcuts**: Defined pointcuts to target specific methods.

### Logging
- **Logger Initialization**: Ensured proper initialization of loggers using `LogFactory.getLog`.
- **Logging Configuration**: Configured logging levels in `application.properties`.

### Maven
- **Dependencies**: Managed project dependencies using `pom.xml`.

## Challenges and Solutions
- **Detached Entity Exception**: Switched from `persist` to `merge` to handle detached entities.
- **Annotation Exceptions**: Corrected entity mappings to resolve `AnnotationException`.
- **NullPointerException in Logging**: Ensured proper initialization of loggers to avoid `NullPointerException`.

## Additional Notes
- **Convenience Methods**: Added convenience methods in entities for better management of relationships.
- **Performance Monitoring**: Used `@Around` advice to monitor method execution time.