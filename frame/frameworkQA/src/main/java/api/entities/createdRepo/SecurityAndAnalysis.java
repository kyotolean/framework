package api.entities.createdRepo;

import lombok.Data;

@Data
public class SecurityAndAnalysis {
    private SecretScanning secret_scanning;
    private SecretScanningPushProtection secret_scanning_push_protection;
    private DependabotSecurityUpdates dependabot_security_updates;
    private SecretScanningValidityChecks secret_scanning_validity_checks;
}
