package ch.noseryoung.uek295_account.exceptions;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String resourceName, UUID id) {
    super(String.format("%s with ID %s not found", resourceName, id));
  }
}