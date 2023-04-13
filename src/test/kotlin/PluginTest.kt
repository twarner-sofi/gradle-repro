import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.io.TempDir
import java.io.File
import kotlin.test.Test
import kotlin.test.assertContains

class PluginTest {
    @Test
    fun test(@TempDir projectDir: File) {
        projectDir.resolve("settings.gradle.kts").createNewFile()
        projectDir.resolve("build.gradle.kts").writeText(
            """
                plugins {
                    id("com.sofi.test")
                }
            """.trimIndent()
        )

        val runner = GradleRunner.create()
            .withGradleVersion("8.0.2")
            .withPluginClasspath()
            .withProjectDir(projectDir)
            .forwardOutput()
            .withArguments("printHello")

        val result = assertDoesNotThrow { runner.build() }

        assertContains(result.output, "hello gradle 8.0.2")
    }
}
