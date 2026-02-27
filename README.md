# event-promoter-backend

This is a sample project for the Event Promoter backend.
The goal is to demonstrate a simple API for a template-driver-structure application.

## Setup instructions
Edit Github Action deployment for your specific environment (prefer to use Github Runner!)
Add your Docker HUB

## Stack and library choices

| Technology  | Status          | Why I chose it |
|-------------|-----------------|----------------|
| Kotlin      | ✅ In use      | Modern, concise JVM language with excellent null safety and coroutines for async programming. |
| Ktor        | ✅ In use      | Lightweight, asynchronous web framework perfect for building scalable APIs. |
| HikariCP    | ⏳ Planned     | High-performance JDBC connection pool for efficient database connections. |
| Exposed     | ⏳ Planned     | Kotlin-first SQL framework that's type-safe and fluent for database operations. |
| H2          | ⏳ Planned     | Embedded database for easy local development and testing. |
| MongoDB     | ⏳ Planned     | Document database for flexible, schema-less data storage. |
| PostgreSQL  | ⏳ Planned     | Robust, production-ready relational database with excellent features. |
| Keycloak    | ⏳ Planned     | Open-source identity and access management for secure authentication. |

## Key decisions, tradeoffs, suggestions for future development

### Key decisions
- **Kotlin and Ktor**: Chosen for concise, type‑safe server‑side code and built‑in support for coroutines, enabling clean asynchronous APIs.
- **Modular architecture**: Project structured into modules (e.g., routes, services, data) to keep concerns separate and improve testability.
- **Configuration‑based environment setup**: Using config files (e.g., HOCON or JSON) to manage environment‑specific settings rather than hard‑coded values.

### Tradeoffs
- **Kotlin/JVM vs lighter stacks**: Gave up some startup speed and memory footprint compared to lighter runtimes (e.g., Node.js) for better type safety and tooling.
- **Ktor vs heavier frameworks**: Gained flexibility and minimal overhead but took on more responsibility for wiring infrastructure (logging, auth, DB access) manually.
- **Planned databases (H2, HikariCP, Exposed, PostgreSQL, MongoDB)**: Delayed full persistence implementation to focus on core API design first, at the cost of incomplete end‑to‑end data flows in early stages.

### Suggestions for future development
- **IAM**: Remove user management, integrate tian IAM for better security.
- **Add proper database layers**: Implement HikariCP with Exposed for PostgreSQL and H2 for testing, then introduce MongoDB for document‑oriented use cases.
- **Integrate Keycloak**: Add proper OAuth2/OpenID Connect authentication and role‑based access control.
- **Improve testing**: Add integration tests against real (or embedded) databases and contract tests for API endpoints.
- **Observability**: Add structured logging, metrics, and optionally distributed tracing for production readiness.
- **CI/CD and containerization**: Introduce Docker and GitHub Actions (or similar) to automate builds, tests, and deployments.

Thanks Perplexity!