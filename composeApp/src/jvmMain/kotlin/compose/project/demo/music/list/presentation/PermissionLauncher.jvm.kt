package compose.project.demo.music.list.presentation

import androidx.compose.runtime.Composable

@Composable
actual fun PermissionLauncher(
    permission: String,
    onResult: (Boolean) -> Unit
): () -> Unit {
    return { onResult(true) }
}
