package pablo.tzeliks.app.domain.user.domain;

import java.time.Instant;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {

    private final UUID id;
    private final String username;
    private final String password;
    private final Set<Role> roles;
    private final Instant createdAt;
    private Instant updatedAt;

    public User(String username, String password) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.roles = new HashSet<>();
        this.roles.add(Role.USER);
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public User(UUID id, String username, String password, Set<Role> roles, Instant createdAt, Instant updatedAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles != null ? roles : new HashSet<>();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return Collections.unmodifiableSet(roles);
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
