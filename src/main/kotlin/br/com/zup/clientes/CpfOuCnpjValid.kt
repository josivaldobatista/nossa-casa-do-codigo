package br.com.zup.clientes

import io.micronaut.core.annotation.AnnotationValue
import io.micronaut.validation.validator.constraints.ConstraintValidator
import io.micronaut.validation.validator.constraints.ConstraintValidatorContext
import javax.inject.Singleton
import javax.validation.Constraint
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.*

@MustBeDocumented
@Target(FIELD, CONSTRUCTOR)
@Retention(RUNTIME)
@Constraint(validatedBy = [CpfOuCnpjValidate::class])
annotation class CpfOuCnpjValid(
  val message: String = "CPF ou CNPJ no formato inválido"
)

@Singleton
class CpfOuCnpjValidate: ConstraintValidator<CpfOuCnpjValid, String> {

  override fun isValid(
    value: String?,
    annotationMetadata: AnnotationValue<CpfOuCnpjValid>,
    context: ConstraintValidatorContext
  ): Boolean {

    if (value == null) {
      return true
    }

    return value.matches(
      "(^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}\$)|(^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}\$)".toRegex())
  }

}
